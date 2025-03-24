package fr.lfi.datacollection;

public class SurveyResponse {
    private final String feelingToday;
    private final String ifMayor;
    private final String district;
    private final String voteRegistry;

    public SurveyResponse(String feelingToday, String ifMayor, String district, String voteRegistry) {
        this.feelingToday = feelingToday;
        this.ifMayor = ifMayor;
        this.district = district;
        this.voteRegistry = voteRegistry;
    }

    public String getDistrict() {
        return district;
    }

    public String getVoteRegistry() {
        return voteRegistry;
    }

    @Override
    public String toString() {
        return "SurveyResponse{" + '\n' +
                "   feelingToday='" + feelingToday + ", \n" +
                "   ifMayor='" + ifMayor + ", \n" +
                '}';
    }
}
