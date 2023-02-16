import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String EXIST_LINE = "-------";
    private static final String NON_EXIST_LINE = "       ";
    private static final String WALL = "|";

    private final int numberOfLine;
    private List<LineStatus> line = new ArrayList<>();

    public Line(int numberOfLine, LineGenerator lineGenerator) {
        this.numberOfLine = numberOfLine;
        makeLine(lineGenerator);
    }

    private void makeLine(LineGenerator lineGenerator) {
        line.add(LineStatus.findBy(lineGenerator.generate(false)));
        for (int i = 1; i < this.numberOfLine; i++) {
            line.add(LineStatus.findBy(lineGenerator.generate(line.get(i-1).getStatus())));
        }
    }

    public String getLineStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append(WALL);
        for (LineStatus lineStatus : line) {
            buildLine(sb, lineStatus);
        }

        return sb.toString();
    }

    private void buildLine(StringBuilder sb, LineStatus lineStatus) {
        if (lineStatus.getStatus()) {
            sb.append(EXIST_LINE);
        }
        if (!lineStatus.getStatus()) {
            sb.append(NON_EXIST_LINE);
        }
        sb.append(WALL);
    }

    public List<LineStatus> getLine() {
        return this.line;
    }
}
