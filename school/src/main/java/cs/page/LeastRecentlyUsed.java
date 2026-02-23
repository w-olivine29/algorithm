package cs.page;

import java.util.LinkedHashSet;


public class LeastRecentlyUsed implements PageReplacementStrategy {

    private final int frameSize;
    private final LinkedHashSet<Integer> frames; // 조회, 삭제 성능을 위해 HashSet, 참조순서를 위해 Linked 선택

    public LeastRecentlyUsed(int frameSize) {
        this.frameSize = frameSize;
        frames = new LinkedHashSet<>();
    }

    @Override
    public PageReferResult refer(int refNumber) {

        PageReferResult result = new PageReferResult(refNumber);

        if (!frames.contains(refNumber)) {
            handleFault(refNumber, result);
        } else {
            handleHit(refNumber, result);
        }

        result.setFrames(frames);
        return result;
    }

    private void handleHit(int refNumber, PageReferResult result) {
        // 히트: 해당 페이지가 있으면 해당 요소를 제거 후 다시 추가 (참조순서 갱신)
        frames.remove(refNumber);
        frames.add(refNumber);
        result.setActionMessage(result.getReferPage() + " 재정렬");
    }

    private void handleFault(int refNumber, PageReferResult result) {
        result.setFault(true);

        // 프레임 포화상태면 맨 앞의 요소 삭제 (참조된지 가장 오래된 요소)
        if (frames.size() >= frameSize) {
            removePage(result);
            result.setActionMessage(result.getRemovedPage() + " 제거");
            frames.add(refNumber);

        } else {
            // 별도 액션메세지 없음
            frames.add(refNumber);
        }
    }

    private void removePage(PageReferResult result) {

        // set은 직접 특정순서 요소에 접근하지 못하니까 iterator 사용하여 첫번째 요소 접근
        Integer oldestPage = frames.iterator().next();
        frames.remove(oldestPage);
        result.setRemovedPage(oldestPage);
    }


}
