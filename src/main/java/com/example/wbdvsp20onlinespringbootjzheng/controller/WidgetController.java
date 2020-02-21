package com.example.wbdvsp20onlinespringbootjzheng.controller;

import com.example.wbdvsp20onlinespringbootjzheng.models.Widget;
import com.example.wbdvsp20onlinespringbootjzheng.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {


    WidgetService widgetService = new WidgetService();

    @PostMapping("/topics/{topicId}/widgets")
    public Widget createWidget(@RequestBody Widget newWidget, @PathVariable String topicId) {
        return widgetService.createWidget(newWidget,topicId);
    }

    @DeleteMapping("/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") String widgetId) {
        return widgetService.deleteWidget(widgetId);
    }


    @GetMapping("/widgets")
    public List<Widget> findAllWidget() {
        return widgetService.findAllWidget();
    }

    @GetMapping("topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("topicId") String topicId) {
        return widgetService.findWidgetsForTopic(topicId);
    }

    @PutMapping("/widgets/{widgetId}")
    public int updateWidget(@PathVariable("widgetId") String widgetId,
                            @RequestBody Widget widget) {
        return widgetService.updateWidget(widgetId, widget);
    }
}
