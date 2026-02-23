package cs.page;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstInFirstOut implements PageReplacementStrategy {

    private final int frameSize;
    private final Queue<Integer> frames;

    public FirstInFirstOut(int frameSize) {
        this.frameSize = frameSize;
        this.frames = new ArrayDeque<>();
    }

    @Override
    public PageReferResult refer(int refNumber) {

        PageReferResult result = new PageReferResult(refNumber);

        // 페이지 폴트
        if (!frames.contains(refNumber)) {
            handleFault(refNumber, result);
        }

        // 참조 후 프레임 상태
        result.setFrames(frames);
        return result;
    }

    private void handleFault(int refNumber, PageReferResult result) {
        result.setFault(true);

        // 페이지 교체
        if (frames.size() >= frameSize) {
            result.setRemovedPage(frames.poll());
            result.setActionMessage(result.getRemovedPage() + " 제거");
        }
        frames.offer(refNumber);
    }
}
