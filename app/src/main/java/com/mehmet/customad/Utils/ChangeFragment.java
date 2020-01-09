package com.mehmet.customad.Utils;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.mehmet.customad.R;

public class ChangeFragment {

    private Context context;


    public ChangeFragment(Context context) {
        this.context = context;
    }

    public void change(Fragment fragment) {

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    public void change2(Fragment fragment, String info) {

        Bundle bundle=new Bundle();
        bundle.putString("info",info);
        fragment.setArguments(bundle);

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    public void change3(Fragment fragment, int info) {

        Bundle bundle=new Bundle();
        bundle.putInt("infoInt",info);
        fragment.setArguments(bundle);

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    public void change4(Fragment fragment, String infoString, int index) {

        Bundle bundle=new Bundle();
        bundle.putInt("infoIndex",index);
        bundle.putString("infoString",infoString);
        fragment.setArguments(bundle);

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    public void change5(Fragment fragment, String infoString, String infoString2, int index) {

        Bundle bundle=new Bundle();
        bundle.putInt("infoIndex",index);
        bundle.putString("infoString",infoString);
        bundle.putString("infoString2",infoString2);
        fragment.setArguments(bundle);

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    public void change6(Fragment fragment, String infoString, String infoString2, String infoString3, int index) {

        Bundle bundle=new Bundle();
        bundle.putInt("infoIndex",index);
        bundle.putString("infoString",infoString);
        bundle.putString("infoString2",infoString2);
        bundle.putString("infoString3",infoString3);
        fragment.setArguments(bundle);

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

}
