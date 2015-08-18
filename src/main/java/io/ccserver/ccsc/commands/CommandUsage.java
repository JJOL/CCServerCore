package io.ccserver.ccsc.commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by JJOL on 17/08/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandUsage {

    String value();

}
