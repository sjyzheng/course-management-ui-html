package com.example.wbdvsp20onlinespringbootjzheng.services;
import com.example.wbdvsp20onlinespringbootjzheng.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {

    List<Widget> widgets = new ArrayList<>();

    public Widget createWidget(String tid, Widget newWidget) {
        widgets.add(newWidget);
        return newWidget;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> resultWidgets = new ArrayList<>();
        for (Widget widget: widgets) {
            if (widget.getTopicId().equals(tid)) resultWidgets.add(widget);
        }
        return resultWidgets;
    }

    public int updateWidget(String wid, Widget widget) {
        for (int i=0; i<widgets.size(); i++) {
            Widget curWidget = widgets.get(i);
            if (curWidget.getId().equals(wid)) {
                widgets.set(i, widget);
            }
        }
        return 1;
    }

    public int deleteWidget(String wid) {
        widgets = widgets.stream()
                .filter(widget -> !widget.getId().equals(wid))
                .collect(Collectors.toList());
        return 1;
    }

//    public List<Widget> findAllWidget() {
//        Widget w1 = new Widget();
//        Widget w2 = new Widget();
//        List<Widget> widgets = new ArrayList<>();
//
//        w1.setTitle("W1");
//        w1.setType("Heading");
//        w2.setTitle("W2");
//        widgets.add(w1);
//        widgets.add(w2);
//
//        return widgets;
//    }

}
