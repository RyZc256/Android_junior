package com.example.zry0134.ui.chart.bar;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.zry0134.R;
import com.example.zry0134.base.BaseFragment2;
import com.example.zry0134.ui.chart.line.LineViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class BarFragment extends BaseFragment2 {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bar, container, false);
        BarChart chart = root.findViewById(R.id.barChart);
        BarViewModel barViewModel= new ViewModelProvider(this).get(BarViewModel.class);
        barViewModel.getBarList().observe(getViewLifecycleOwner(),barBeans -> {
            //添加数据
            List<BarEntry> entries1 = new ArrayList<>();
            List<BarEntry> entries2 = new ArrayList<>();
            for (int i = 0; i < barBeans.size(); i++) {
                entries1.add(new BarEntry(i,barBeans.get(i).getLineBean1().getSalaries()));
                entries2.add(new BarEntry(i,barBeans.get(i).getLineBean2().getSalaries()));
            }
            //自定义数据样式
            BarDataSet dataSet1 = new BarDataSet(entries1, "Java工资");
            dataSet1.setValueTextColor(Color.RED);
            dataSet1.setValueTextSize(10f);
            dataSet1.setColor(Color.BLUE);
            BarDataSet dataSet2 = new BarDataSet(entries2, "PHP工资");
            dataSet2.setValueTextColor(Color.GREEN);
            dataSet2.setValueTextSize(10f);
            dataSet2.setColor(Color.CYAN);
            BarData barData = new BarData(dataSet1,dataSet2);
            barData.setBarWidth(0.45f);
            chart.setData(barData);
            chart.groupBars(-0.5f,0.04f,0.03f);
            chart.invalidate(); // 刷新
            //X坐标轴设置
            XAxis xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setAxisLineColor(Color.BLACK);
            xAxis.setAxisLineWidth(3f);
            xAxis.setTextSize(10f);
            xAxis.enableGridDashedLine(10f,10f,0f);
            xAxis.setTextColor(Color.BLACK);
            // 自定义值的格式
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return barBeans.get((int)value).getLineBean1().getYear();
                }
            });
            //Y坐标轴设置
            chart.getAxisRight().setEnabled(false);
            YAxis yAxis = chart.getAxisLeft();
            yAxis.setAxisLineColor(Color.BLACK);
            yAxis.setAxisLineWidth(3f);
            yAxis.setTextSize(10f);
            yAxis.enableGridDashedLine(10f,10f,0f);
            yAxis.setTextColor(Color.BLACK);
            yAxis.setAxisMinimum(0f); // 起始值为0
            yAxis.setSpaceTop(38.2f); //黄金分割
            LimitLine limitLine=new LimitLine(10000f,"厦门市平均工资");
            limitLine.setLineColor(Color.MAGENTA);
            limitLine.setLineWidth(2f);
            yAxis.addLimitLine(limitLine);
            //设置图例
            Legend l = chart.getLegend();
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            //设置描述
            Description description = chart.getDescription();
            description.setText("Java/PHP工程师经验与工资的对应情况");
            description.setTextColor(Color.BLACK);
            description.setTextSize(16f);
            description.setTextAlign(Paint.Align.CENTER);
            description.setPosition(540f,100f);
            chart.animateY(5000);//设置动画
        });
        return root;
    }
}
