package auto.model.panel;

import auto.data.enums.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ChartSettings extends DisplaySettings{
    private String chartTitle;
//    private boolean showTitle;
//    @Builder.Default
//    private ChartType chartType = ChartType.PIE;
//    @Builder.Default
//    private ChartStyle chartStyle = ChartStyle.STYLE_2D;
//    private ChartCategory category;
//    private String categoryCaption;
//    private ChartSeries series;
//    private String seriesCaption;
//    @Builder.Default
//    private ChartLegends legends = ChartLegends.BOTTOM;
//    private ChartDataLabels dataLabels;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ChartSettings that = (ChartSettings) o;
//        return showTitle == that.showTitle
//                && Objects.equals(chartTitle, that.chartTitle)
//                && chartType == that.chartType
//                && chartStyle == that.chartStyle
//                && category == that.category
//                && Objects.equals(categoryCaption, that.categoryCaption)
//                && series == that.series
//                && Objects.equals(seriesCaption, that.seriesCaption)
//                && legends == that.legends
//                && dataLabels == that.dataLabels;
//    }
}
