package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   */
  VideoObj(String title, int year, String director) {
    _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    // TODO
    return "director";
  }

  public String title() {
    // TODO
    return "title";
  }

  public int year() {
    // TODO
    return -1;
  }

  public boolean equals(Object thatObject) {
    // TODO
    return false;
  }

  public int hashCode() {
    // TODO
    return -1;
  }

  public int compareTo(Video that) {
    // TODO
    return -1;
  }

  public String toString() {
    // TODO
    return "El Mariachi (1996) : Rodriguez";
  }
}
