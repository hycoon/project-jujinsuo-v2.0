package jujinsuo.yuanze.com.jujinsuo_v20.api;




import jujinsuo.yuanze.com.jujinsuo_v20.reponse.Login;
import jujinsuo.yuanze.com.jujinsuo_v20.requestparamete.LoginParams;
import rx.Observable;

/**
 *  Api类的包装
 */
public class ApiWrapper extends Api {

    public Observable<Login> getUerInfo(LoginParams mLoginParams) {
        return applySchedulers(getService().getPersonalInfo(mLoginParams));
    }


}
