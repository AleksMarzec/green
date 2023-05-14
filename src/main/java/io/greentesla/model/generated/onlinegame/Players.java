package io.greentesla.model.generated.onlinegame;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Players
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:53.976764680Z[GMT]")


public class Players {
    @JsonProperty("groupCount")
    private Integer groupCount = null;

    @JsonProperty("clans")
    @Valid
    private List<Clan> clans = null;

    public Players groupCount(Integer groupCount) {
        this.groupCount = groupCount;
        return this;
    }

    /**
     * Number of players in single group
     * minimum: 1
     * maximum: 1000
     *
     * @return groupCount
     **/
    @Schema(example = "6", description = "Number of players in single group")

    @Min(1)
    @Max(1000)
    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public Players clans(List<Clan> clans) {
        this.clans = clans;
        return this;
    }

    public Players addClansItem(Clan clansItem) {
        if (this.clans == null) {
            this.clans = new ArrayList<Clan>();
        }
        this.clans.add(clansItem);
        return this;
    }

    /**
     * Get clans
     *
     * @return clans
     **/
    @Schema(description = "")
    @Valid
    @Size(max = 20000)
    public List<Clan> getClans() {
        return clans;
    }

    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Players players = (Players) o;
        return Objects.equals(this.groupCount, players.groupCount) &&
                Objects.equals(this.clans, players.clans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCount, clans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Players {\n");

        sb.append("    groupCount: ").append(toIndentedString(groupCount)).append("\n");
        sb.append("    clans: ").append(toIndentedString(clans)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
