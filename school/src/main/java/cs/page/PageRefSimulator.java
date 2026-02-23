package cs.page;

import java.util.List;

public class PageRefSimulator {

    private PageReplacementStrategy pageReplacementStrategy;
    private int totalFaultCount;


    public PageRefSimulator(PageReplacementStrategy pageReplacementStrategy) {
        this.pageReplacementStrategy = pageReplacementStrategy;
    }

    public void execute(List<Integer> pageRefs) {

        printResult(null); // 초기 시작상태 출력

        for (Integer pageNumber : pageRefs) {
            PageReferResult refResult = pageReplacementStrategy.refer(pageNumber);
            printResult(refResult);

            if (refResult.isFault()) totalFaultCount++;
        }

        System.out.println("페이지폴트: " + totalFaultCount);
    }

    // 현재 참조하는 페이지 : [참조후 프레임 상태] (폴트여부, 제거한 페이지)
    private void printResult(PageReferResult result) {
        if (result == null) {
            System.out.println("초기: []");
            return;
        }
        StringBuilder builder = new StringBuilder();

        builder.append(result.getReferPage()); // 참조페이지
        builder.append(": ");

        builder.append(result.getFrames());    // 프레임 상태

        builder.append("(");
        builder.append(result.isFault() ? "폴트" : "히트"); // 폴트 여부

        // 액션 메세지 추가
        if(result.getActionMessage() != null){
            builder.append(", ");
            builder.append(result.getActionMessage());
        }

        builder.append(")");
        System.out.println(builder);
    }


    public static void main(String[] args) {

        // 참조 될 페이지
        List<Integer> refPages = List.of(1, 2, 3, 4, 2, 5, 1, 2, 3, 4, 5, 1);

        PageRefSimulator fifoSimulator = new PageRefSimulator(new FirstInFirstOut(3));
        fifoSimulator.execute(refPages);

        System.out.println();

        PageRefSimulator lruSimulator = new PageRefSimulator(new LeastRecentlyUsed(3));
        lruSimulator.execute(refPages);
    }

}
