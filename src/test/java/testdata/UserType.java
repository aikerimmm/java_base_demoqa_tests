package testdata;

public enum UserType {
    locked_out_user ("locked_out_user"),
    problem_user ("problem_user"),
    performance_glitch_user ("performance_glitch_user"),
    error_user ("error_user"),
    visual_user ("visual_user"),
    standard_user("standard_user");

    public final String description ;

    UserType(String description) {
        this.description = description;
    }
}
