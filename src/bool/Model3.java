package bool;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @Auther: liXu
 * @Date: 2019/12/25 11:29
 * @Description:
 */
class Model3 implements Serializable {

    private static final long serialVersionUID = 1836697963736227954L;
    private boolean isSuccess;
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean success) {
        isSuccess = success;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Model3.class.getSimpleName() + "[","]")
                .add("isSuccess=" + isSuccess)
                .toString();
    }
}
