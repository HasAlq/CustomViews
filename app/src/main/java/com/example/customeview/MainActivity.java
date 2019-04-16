package com.example.customeview;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    AnyChartView anyChartView;
    Cartesian cartesian;
    List<DataEntry> data;
    Column column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anyChartView = findViewById(R.id.any_chart_view);

        cartesian = AnyChart.column();

        data = new ArrayList<>();
        data.add(new ValueDataEntry("Rouge", 80540));
        data.add(new ValueDataEntry("Foundation", 94190));
        data.add(new ValueDataEntry("Mascara", 102610));
        data.add(new ValueDataEntry("Lip gloss", 110430));
        data.add(new ValueDataEntry("Lipstick", 128000));
        data.add(new ValueDataEntry("Nail polish", 143760));
        data.add(new ValueDataEntry("Eyebrow pencil", 170670));
        data.add(new ValueDataEntry("Eyeliner", 213210));
        data.add(new ValueDataEntry("Eyeshadows", 249980));

        column = cartesian.column(data);

        column.color("red");

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Top 10 Cosmetic Products by Revenue");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Product");
        cartesian.yAxis(0).title("Revenue");

        anyChartView.setChart(cartesian);
    }

    public void changeData(View v){

        Random random = new Random();
        int n = random.nextInt();

        anyChartView.clear();

        cartesian = AnyChart.column();

        data.add(new ValueDataEntry("Rouge", 55));
        data.add(new ValueDataEntry("Foundation", 320));


//        data.add(new ValueDataEntry("Foundation", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Mascara", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Lip gloss", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Lipstick", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Nail polish", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Eyebrow pencil", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Eyeliner", random.nextInt(1000)));
//        data.add(new ValueDataEntry("Eyeshadows", random.nextInt(1000)));

        column = cartesian.column(data);

        anyChartView.setChart(cartesian);

    }

    private class CustomDataEntry extends DataEntry {
        CustomDataEntry(Integer x, Integer value, String color) {
            setValue("x", x);
            setValue("value", value);
            setValue("color", color);
        }
    }
}


