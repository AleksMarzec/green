package io.greentesla.model.generated.onlinegame;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

/**
 * Clan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:53.976764680Z[GMT]")


public class Clan {
    @JsonProperty("numberOfPlayers")
    private Integer numberOfPlayers = null;

    @JsonProperty("points")
    private Integer points = null;

    public Clan numberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        return this;
    }

    /**
     * Get numberOfPlayers
     * minimum: 1
     * maximum: 1000
     *
     * @return numberOfPlayers
     **/
    @Schema(example = "10", description = "")

    @Min(1)
    @Max(1000)
    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Clan points(Integer points) {
        this.points = points;
        return this;
    }

    /**
     * Get points
     * minimum: 1
     * maximum: 1000000
     *
     * @return points
     **/
    @Schema(example = "500", description = "")

    @Min(1)
    @Max(1000000)
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Clan clan = (Clan) o;
        return Objects.equals(this.numberOfPlayers, clan.numberOfPlayers) &&
                Objects.equals(this.points, clan.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPlayers, points);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Clan {\n");

        sb.append("    numberOfPlayers: ").append(toIndentedString(numberOfPlayers)).append("\n");
        sb.append("    points: ").append(toIndentedString(points)).append("\n");
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

