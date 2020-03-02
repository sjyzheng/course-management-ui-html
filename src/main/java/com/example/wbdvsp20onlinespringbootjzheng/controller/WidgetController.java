package com.example.wbdvsp20onlinespringbootjzheng.controller;

import com.example.wbdvsp20onlinespringbootjzheng.models.Widget;
import com.example.wbdvsp20onlinespringbootjzheng.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {
    WidgetService widgetService = new WidgetService();

    @PostMapping("api/topics/{topicId}/widgets")
    public Widget createWidget(@PathVariable("topicId") String tid, @RequestBody Widget widget) {
        return widgetService.createWidget(tid, widget);
    }

    @GetMapping("api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("topicId") String tid) {
        return widgetService.findWidgetsForTopic(tid);
    }

    @GetMapping("api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @PutMapping("api/widgets/{widgetId}")
    public int updateWidget(@PathVariable("widgetId") String wid,
                            @RequestBody Widget widget) {
        return widgetService.updateWidget(wid, widget);
    }

    @DeleteMapping("api/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") String wid) {
        return widgetService.deleteWidget(wid);
    }

}
