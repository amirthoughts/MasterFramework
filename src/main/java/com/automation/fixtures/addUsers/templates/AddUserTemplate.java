package com.automation.fixtures.addUsers.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.automation.fixtures.addUsers.entity.UserData;

public class AddUserTemplate implements TemplateLoader {
    @Override
    public void load() {

        Fixture.of(UserData.class).addTemplate("valid", new Rule(){{
            add("userRole", random("ESS", "Admin"));
            add("employeeName", uniqueRandom( "Goutam  Ganesh"));
            add("username", random( "amirthoughts"));
            add("status", random( "Enabled", "Disabled"));
            add("password",random("Password@123"));
            add("message", "Success message is not displayed");
        }});

        Fixture.of(UserData.class).addTemplate("just_employee_name", new Rule(){{
            add("employeeName", random("Sk Amir Ullah"));
            add("message", "Error message is not displayed");
        }});


    }
}
