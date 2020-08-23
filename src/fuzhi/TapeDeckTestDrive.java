package fuzhi;/**
 * @Auther: liXu
 * @Date: 2019/9/5 00:26
 * @Description:
 */

class TapeDeck {
    boolean canRecord = false;
    void playTape() {
        System.out.println("tape playing");
    }
    void recordTape() {
        System.out.println("tape recording");
    }
}
class TapeDeckTestDrive {
    public static void main(String [] args) {
        TapeDeck t = new TapeDeck();
        System.out.println("canRecord的值"+t.canRecord);
        t.canRecord = true;
        t.playTape();
        if (t.canRecord == true) {
            t.recordTape();
        }
    }
}
