package design.alex.starwars.ui.splash;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import design.alex.starwars.R;
import design.alex.starwars.ui.home.HomeActivity;

/**
 * Экран стартовой страницы
 */
public class SplashScreenActivity
        extends
        AppCompatActivity
        implements
        Animator.AnimatorListener,
        SplashScreenActivityView {

    /** Картинка логотипа на странице */
    @BindView(R.id.logo) ImageView mLogo;

    /** Презентер */
    private SplashScreenActivityPresenter mPresenter;

    @Override
    public void onAnimationStart(Animator animation) { }

    @Override
    public void onAnimationEnd(Animator animation) {
        mPresenter.onStopAnimation();
    }

    @Override
    public void onAnimationCancel(Animator animation) { }

    @Override
    public void onAnimationRepeat(Animator animation) { }

    @Override
    public void onStartAnimation() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.logo_animator);
        animator.setTarget(mLogo);
        animator.addListener(this);
        animator.start();
    }

    @Override
    public void onStartHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        ButterKnife.bind(this);

        mPresenter = new SplashScreenActivityPresenterImpl();
        mPresenter.setView(this);

        mPresenter.onCreate();
    }
}
