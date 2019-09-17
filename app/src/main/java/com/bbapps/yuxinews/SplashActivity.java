package com.bbapps.yuxinews;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends Activity {
    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root = (RelativeLayout) findViewById(R.id.rl_splash_root);

        //渐变动画
        AlphaAnimation aa = new AlphaAnimation(0,1); //设置动画从0过渡到1
        aa.setFillAfter(true); //结束后停留在最后一帧

        //缩放动画
        /**
         * 参数说明
         * fromX：起始X坐标上的伸缩尺寸。
         * toX：结束X坐标上的伸缩尺寸。
         * fromY：起始Y坐标上的伸缩尺寸。
         * toY：结束Y坐标上的伸缩尺寸。
         * pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
         * pivotXValue：X坐标的伸缩值。
         * pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
         * pivotYValue：Y坐标的伸缩值。
         * 有三种默认值：
         * RELATIVE_TO_PARENT 相对于父控件
         * RELATIVE_TO_SELF 相对于自己
         * RELATIVE_TO_ABSOLUTE 绝对坐标
         */
        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        sa.setFillAfter(true); //结束后停留在最后一帧

        //旋转动画
        RotateAnimation ra = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setFillAfter(true); //结束后停留在最后一帧

        //设置动画组，让多个动画同时播放
        AnimationSet set = new AnimationSet(false);//false意思是不共享动画变化率（interpolator），集合内每个动画的变化速率单独设置
        //添加动画，无顺序
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        set.setDuration(2000); //动画时长2s

        set.setAnimationListener(new myAnimationListener());

        rl_splash_root.startAnimation(set);
    }

    private class myAnimationListener implements Animation.AnimationListener {
        /**
         * <p>Notifies the start of the animation.</p>
         *
         * @param animation The started animation.
         */
        @Override
        public void onAnimationStart(Animation animation) {

        }

        /**
         * <p>Notifies the end of the animation. This callback is not invoked
         * for animations with repeat count set to INFINITE.</p>
         *
         * @param animation The animation which reached its end.
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(SplashActivity.this, "感谢使用玉溪新闻app，请稍等。。。", Toast.LENGTH_SHORT).show();
        }

        /**
         * <p>Notifies the repetition of the animation.</p>
         *
         * @param animation The animation which was repeated.
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
