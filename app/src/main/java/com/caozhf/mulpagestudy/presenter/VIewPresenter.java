package com.caozhf.mulpagestudy.presenter;

import com.caozhf.mulpagestudy.model.IMP;
import com.caozhf.mulpagestudy.model.Model;

/**
 * Created by CaoZhF on 2018-05-11.
 */

public class VIewPresenter implements IMP{

    private IVP ivp;

    public VIewPresenter(IVP ivp) {
        this.ivp = ivp;
    }

    public void viewGetData(String get_url){
        Model model = new Model(this);
        model.OKHTTPData(get_url);
    }

    @Override
    public void SuccessGet(String string) {
        ivp.GetRequestData(string);
    }

    @Override
    public void FailureGet(String message) {
        ivp.FailureGetData(message);
    }
}
