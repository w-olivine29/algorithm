package cs.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 실습 환경이 자바 11이어서, record 가 아닌 getter, setter 직접 구현
// 결과 출력에 사용됨
public class PageReferResult {
    private List<Integer> frames;
    private int referPage;
    private Integer removedPage;

    private boolean isFault;
    private String actionMessage;

    public PageReferResult(int referPage) {
        this.referPage = referPage;
    }

    public Collection<Integer> getFrames() {
        return frames;
    }

    public int getReferPage() {
        return referPage;
    }

    public Integer getRemovedPage() {
        return removedPage;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public boolean isFault() {
        return isFault;
    }

    public void setFrames(Collection<Integer> frames) {
        this.frames = new ArrayList<>(frames);
    }

    public void setRemovedPage(Integer removedPage) {
        this.removedPage = removedPage;
    }

    public void setFault(boolean fault) {
        isFault = fault;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }
}
