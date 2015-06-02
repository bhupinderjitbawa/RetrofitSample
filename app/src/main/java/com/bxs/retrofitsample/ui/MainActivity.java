package com.bxs.retrofitsample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.bxs.retrofitsample.R;
import com.bxs.retrofitsample.adapters.SalaryListAdapter;
import com.bxs.retrofitsample.interfaces.EmployeeDetailInterface;
import com.bxs.retrofitsample.models.Employee;
import com.bxs.retrofitsample.models.EmployeeWebserviceModel;
import com.bxs.retrofitsample.utils.Constants;
import com.bxs.retrofitsample.utils.CustomUrlConnectionClient;

import java.net.SocketTimeoutException;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {


    private TextView tvName;
    private TextView tvAge;
    private TextView tvDateOfJoining;
    private ListView lvSalariesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        init();

    }

    @Override
    protected void onStart() {
        super.onStart();
        getEmployeeDetailsFromWeb();
    }

    private void getEmployeeDetailsFromWeb(){

        // set up rest adapter, it will always be same, no need for changes
        RestAdapter empDetailsRestAdapter = new RestAdapter.Builder()
                                            .setClient(new CustomUrlConnectionClient())
                                            .setEndpoint(Constants.WEBSERVICE_BASE_URL).build();

        // create interface to pass arguments
        EmployeeDetailInterface employeeDetailInterface = empDetailsRestAdapter.create(EmployeeDetailInterface.class);
        employeeDetailInterface.onSuccessfulDetailsReceive(new Callback<EmployeeWebserviceModel>() {
            @Override
            public void success(EmployeeWebserviceModel employeeWebserviceModel, Response response) {

                if(employeeWebserviceModel.getStatus().getCode().equals("Success")) {

                    if (employeeWebserviceModel != null) {
                        Employee employee = employeeWebserviceModel.getData();
                        if (employee != null) {
                            tvName.setText(employee.getName());
                            tvAge.setText(employee.getAge());
                            tvDateOfJoining.setText(employee.getDateOfJoining());
                            lvSalariesList.setAdapter(new SalaryListAdapter(getApplicationContext(), employee.getSalaries()));
                        }
                    } else {
                        Crouton.makeText(MainActivity.this, Constants.MSG_ERROR_INTERNET_CONNECTION, Style.ALERT).show();
                    }
                } else {
                    Crouton.makeText(MainActivity.this, Constants.MSG_ERROR_INTERNET_CONNECTION, Style.ALERT).show();
                }

            }

            @Override
            public void failure(RetrofitError retrofitError) {

                // throw errors
                // internet connection failure // connection timeout // unexpected error

                if(retrofitError!=null) {
                    if (retrofitError.getKind() == RetrofitError.Kind.NETWORK) {
                        Crouton.makeText(MainActivity.this, Constants.MSG_ERROR_INTERNET_CONNECTION, Style.ALERT).show();
                    } else if (retrofitError.getKind() == RetrofitError.Kind.UNEXPECTED) {
                        Crouton.makeText(MainActivity.this, Constants.MSG_ERROR_UNEXPECTED_ERROR, Style.ALERT).show();
                    } else if (retrofitError.getCause() instanceof SocketTimeoutException) {
                        Crouton.makeText(MainActivity.this, Constants.MSG_ERROR_SLOW_INTERNET_CONNECTION, Style.ALERT).show();
                    }
                } else {
                    Crouton.makeText(MainActivity.this, Constants.MSG_ERROR_INVALID_DATA, Style.ALERT).show();
                }

            }
        });

    }

    private void init(){

        tvName = (TextView) findViewById(R.id.tv_name);
        tvAge = (TextView) findViewById(R.id.tv_age);
        tvDateOfJoining = (TextView) findViewById(R.id.tv_date_of_joinning);
        lvSalariesList = (ListView) findViewById(R.id.listView);

    }



}
