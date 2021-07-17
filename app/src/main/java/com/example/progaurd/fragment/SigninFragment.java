package com.example.progaurd.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.progaurd.R;
import com.example.progaurd.activity.MainActivity;
import com.example.progaurd.activity.RegisterActivity;
import com.example.progaurd.activity.SplashActivity;

import org.jetbrains.annotations.NotNull;

import static com.example.progaurd.activity.RegisterActivity.isForgetPasswordFragment;


public class SigninFragment extends Fragment {

    public SigninFragment() {
        // Required empty public constructor
    }

    private TextView registerTxt;
    private FrameLayout frameLayout;
    private ImageView backBtn;
    private TextView frgtpassTxt;
    private Button loginBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        registerTxt = view.findViewById(R.id.textView9);
        frameLayout = getActivity().findViewById(R.id.register_framelayout);
        backBtn = view.findViewById(R.id.imageView2);
        frgtpassTxt = view.findViewById(R.id.textView7);
        loginBtn = view.findViewById(R.id.button3);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRightFragment(new SignupFragment());
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLeftFragment(new WelcomeFragment());
            }
        });

        frgtpassTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isForgetPasswordFragment = true;
                setRightFragment(new ForgetPasswordFragment());
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void setRightFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private void setLeftFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}