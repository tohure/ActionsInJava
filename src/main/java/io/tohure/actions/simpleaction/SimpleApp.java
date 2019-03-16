package io.tohure.actions.simpleaction;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.services.actions_fulfillment.v2.model.User;

public class SimpleApp extends DialogflowApp {

    @ForIntent("Default Welcome Intent")
    public ActionResponse welcome(ActionRequest request) {
        ResponseBuilder builder = getResponseBuilder(request);

        User user = request.getUser();

        String gretting = "Hi Google Cloud Community, How's it going, folks?";

        if (user != null && !user.getLocale().equals("en-US")) {
            gretting = "¡Que tal Google Cloud Community!, ¿Como están esta noche amigos?";
        }

        builder.add(gretting);
        return builder.build();
    }

    @ForIntent("Topics Today")
    public ActionResponse whatToday(ActionRequest request) {
        ResponseBuilder builder = getResponseBuilder(request);

        User user = request.getUser();

        String topics = "Well, today we'll talk about Firebase and Google Cloud";

        if (user != null && !user.getLocale().equals("en-US")) {
            topics = "Bueno, el día de hoy hablaremos de Firebase y Google Cloud";
        }

        builder.add(topics);
        return builder.build();
    }
}
