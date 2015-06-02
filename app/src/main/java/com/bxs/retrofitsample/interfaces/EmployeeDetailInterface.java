package com.bxs.retrofitsample.interfaces;

import com.bxs.retrofitsample.models.EmployeeWebserviceModel;
import com.bxs.retrofitsample.utils.Constants;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by bhupinder on 2/6/15.
 */
public interface EmployeeDetailInterface {

    @GET("/"+Constants.WEBSERVICE_EMPLOYEE_DETAILS)
    void onSuccessfulDetailsReceive(Callback<EmployeeWebserviceModel> callback);


///// other examples
//    @GET("/ProfessionalProfile/{ProfileUniqueId}/Appointments/{date}")
//    void onSuccessFullAppointmentListLoad(@Path("ProfileUniqueId") String ProfileUniqueId,
//                                          @Path("date") String date,
//                                          @Query("mode") String mode,
//                                          @Query("facilityId") String facilityId,
//                                          @Query("status") String status,
//                                          Callback<AppointmentListModel> callback);
}
