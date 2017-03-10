package jujinsuo.yuanze.com.jujinsuo_v20.api;




import jujinsuo.yuanze.com.jujinsuo_v20.reponse.Login;
import jujinsuo.yuanze.com.jujinsuo_v20.requestparamete.LoginParams;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by Sunflower on 2015/11/4.
 */
public interface ApiService {


    /**
     * 获取个人信息
     */
    @POST("account/v1/login")
    Observable<Login> getPersonalInfo(@Body LoginParams mLoginParams);


}
