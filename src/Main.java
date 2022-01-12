import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Range> ranges = new ArrayList<>();
        ranges.add(new Range(10, 15));
        ranges.add(new Range(11, 16));
        ranges.add(new Range(5, 6));
        ranges.add(new Range(16, 20));
        ranges.add(new Range(15, 20));
        ranges.add(new Range(2, 18));
        ranges.add(new Range(22, 50));
        List<Range> validRanges = validate(ranges);
        System.out.println(ranges);
        System.out.println(validRanges);

    }

    private static List<Range> validate(List<Range> ranges) {
        List<Range> result = new ArrayList<>();
        result.add(ranges.get(0));
        for (int i = 1; i < ranges.size(); i++) {
            if (validator(result, ranges.get(i))) {
                result.add(ranges.get(i));
            }
        }
        return result;
    }

    private static boolean validator(List<Range> ranges, Range range) {
        boolean flag = true;
        for (Range listRange : ranges) {
            if (0 >= (listRange.getFrom() - range.getTo()) * (listRange.getFrom() - range.getFrom())) {
                flag = false;
                break;
            }
            if (0 >= (listRange.getTo() - range.getTo()) * (listRange.getTo() - range.getFrom())) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
