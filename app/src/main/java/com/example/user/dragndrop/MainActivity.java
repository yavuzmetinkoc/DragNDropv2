package com.example.user.dragndrop;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    LinearLayout kaynakAlan,ustlinear;
    public static int kontrol=0;
    ImageView yukari,uc,sol,sag,harita1,harita2,harita3,harita4,harita5,harita6,harita7,harita8,harita9;
    TextView basarili;
    TextView toplam;
    int deneme;
    int hatali = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(kontrol==9){
            yukari.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.VISIBLE);
        }

        kaynakAlan = (LinearLayout) findViewById(R.id.ustlinear);
        yukari = (ImageView) findViewById(R.id.iv_yukari);
        uc = (ImageView) findViewById(R.id.iv_uc);
        sol = (ImageView) findViewById(R.id.iv_sol);
        sag = (ImageView) findViewById(R.id.iv_sag);

        harita1=(ImageView)findViewById(R.id.imageView1);
        harita2=(ImageView)findViewById(R.id.imageView2);
        harita3=(ImageView)findViewById(R.id.imageView3);
        harita4=(ImageView)findViewById(R.id.imageView4);
        harita5=(ImageView)findViewById(R.id.imageView5);
        harita6=(ImageView)findViewById(R.id.imageView6);
        harita7=(ImageView)findViewById(R.id.imageView7);
        harita8=(ImageView)findViewById(R.id.imageView8);
        harita9=(ImageView)findViewById(R.id.imageView9);

        ustlinear=(LinearLayout)findViewById(R.id.ustlinear);

        toplam = (TextView) findViewById(R.id.tv_toplam);
        basarili = (TextView) findViewById(R.id.tv_basarili);

        kaynakAlan.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action = event.getAction();
                switch (action) {

                    case DragEvent.ACTION_DROP: {
                        hatali++;
                        break;
                    }

                    case DragEvent.ACTION_DRAG_ENDED: {
                        if(yukari.getVisibility()==View.VISIBLE){
                            if(kontrol==0){
                                harita1.setBackgroundResource(R.drawable.blue);
                                harita1.setImageResource(R.drawable.blue);
                                ustlinear.setBackgroundResource(R.drawable.blue);
                                kontrol++;
                            }else if(kontrol==1){
                                harita2.setBackgroundResource(R.drawable.blue);
                                harita2.setImageResource(R.drawable.blue);
                                yukari.setVisibility(View.INVISIBLE);
                                sag.setVisibility(View.VISIBLE);
                                kontrol++;
                            }
                            else if(kontrol==3){
                                harita4.setBackgroundResource(R.drawable.blue);
                                harita4.setImageResource(R.drawable.blue);
                                kontrol++;
                            }
                            else if(kontrol==4){
                                harita5.setBackgroundResource(R.drawable.blue);
                                harita5.setImageResource(R.drawable.blue);
                                kontrol++;
                                yukari.setVisibility(View.INVISIBLE);
                                sol.setVisibility(View.VISIBLE);
                            }
                            else if(kontrol==7){
                                harita8.setBackgroundResource(R.drawable.blue);
                                harita8.setImageResource(R.drawable.blue);
                                kontrol++;
                            }
                            else if(kontrol==8){
                                harita9.setBackgroundResource(R.drawable.blue);
                                harita9.setImageResource(R.drawable.blue);
                                kontrol++;
                                yukari.setVisibility(View.INVISIBLE);
                                uc.setVisibility(View.VISIBLE);
                            }
                        }
                        else if(sag.getVisibility()==View.VISIBLE){
                            if(kontrol==2){
                                harita3.setBackgroundResource(R.drawable.blue);
                                harita3.setImageResource(R.drawable.blue);
                                kontrol++;
                                sag.setVisibility(View.INVISIBLE);
                                yukari.setVisibility(View.VISIBLE);
                            }
                        }
                        else if(sol.getVisibility()==View.VISIBLE){
                            if(kontrol==5){
                                harita6.setBackgroundResource(R.drawable.blue);
                                harita6.setImageResource(R.drawable.blue);
                                kontrol++;
                            }
                            else if(kontrol==6){
                                harita7.setBackgroundResource(R.drawable.blue);
                                harita7.setImageResource(R.drawable.blue);
                                kontrol++;
                                sol.setVisibility(View.INVISIBLE);
                                yukari.setVisibility(View.VISIBLE);
                            }
                        }

                        break;

                    }

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    default:
                        break;
                }
                return true;
            }
        });
        yukari.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData veri = ClipData.newPlainText("", "");
                View.DragShadowBuilder golge = new View.DragShadowBuilder(yukari);
                v.startDrag(veri, golge, null, 0);
                return false;
            }
        });


        sol.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData veri = ClipData.newPlainText("", "");
                View.DragShadowBuilder golge = new View.DragShadowBuilder(sol);
                v.startDrag(veri, golge, null, 0);
                return false;
            }
        });
        sag.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData veri = ClipData.newPlainText("", "");
                View.DragShadowBuilder golge = new View.DragShadowBuilder(sag);
                v.startDrag(veri, golge, null, 0);
                return false;
            }
        });


    }

    private final class MyTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.yukari);
        Drawable normalShape = getResources().getDrawable(R.drawable.gray);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                default:
                    break;
            }
            return true;
        }
    }
}




