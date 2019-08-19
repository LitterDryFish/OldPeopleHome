package com.scorpiomiku.oldpeoplehome.modules.oldpeople.fragmemt;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.scorpiomiku.oldpeoplehome.R;
import com.scorpiomiku.oldpeoplehome.base.BaseFragment;
import com.scorpiomiku.oldpeoplehome.utils.ChartUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.itangqi.waveloadingview.WaveLoadingView;

/**
 * Created by ScorpioMiku on 2019/8/18.
 */

public class HeartRateFragment extends BaseFragment {
    @BindView(R.id.waveLoadingView)
    WaveLoadingView waveLoadingView;
    @BindView(R.id.heart_rate_text)
    TextView heartRateText;
    @BindView(R.id.begin)
    TextView begin;
    @BindView(R.id.chart)
    LineChart chart;
    Unbinder unbinder;

    @Override
    protected Handler initHandle() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_old_heart_rate;
    }

    @Override
    protected void refreshData() {

    }

    @Override
    protected void initView() {
        initChart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 初始化折线图
     */
    private void initChart() {
        ArrayList<Entry> pointValues = new ArrayList<>();
        pointValues.add(new Entry(0, 100));
        ArrayList<Float> data = new ArrayList<>();
        int i;
        float[] levels = {2f, 90f, 60f, 88f};
        for (i = 1; i <= levels.length - 1; i++) {
            pointValues.add(new Entry(i, Float.valueOf(levels[i])));
            data.add(Float.valueOf(levels[i]));
        }
        pointValues.add(new Entry(i, 0));
        ChartUtils.initSingleLineChart(chart, pointValues, "心率统计图");
    }

}