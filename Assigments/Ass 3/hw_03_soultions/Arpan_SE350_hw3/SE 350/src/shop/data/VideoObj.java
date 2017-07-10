 package shop.data;

//import hw1.VideoObj;

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
    //return "director";
	  return this._director;
  }

  public String title() {
    // TODO
    //return "title";
	  return this._title;
  }

  public int year() {
    // TODO
    //return -1;
	  return this._year;
  }

  public boolean equals(Object thatObject) {
    // TODO
    //return false;
	  if(thatObject== null) return false;
	  if(thatObject.getClass()!=VideoObj.class) 
		  return false;
	  VideoObj video = (VideoObj) thatObject;
	  if((video.title().equals(this.title()))&&(video.year()==this.year())&&(video.director().equals(this.director()))) return true;
	  return false;
  }

  public int hashCode() {
    // TODO
    //return -1;
	  int outcome = 17;
		 outcome = 37*outcome + this._title.hashCode();
		 outcome = 37*outcome + this._year;
		 outcome = 37*outcome + this._director.hashCode();
		 return outcome;
  }

  public int compareTo(Video that) {
    // TODO
   // return -1;
	  if(that == null) throw new NullPointerException();
		VideoObj vid = (VideoObj) that;
	    return this.title().compareTo(vid.title())+Integer.compare(this.year(), vid.year())+this.director().compareTo(vid.director());	
  // -1;
  }

  public String toString() {
    // TODO
    //return "El Mariachi (1996) : Rodriguez";
	  StringBuilder buffer = new StringBuilder();
		buffer.append(_title);
		buffer.append(" (");
		buffer.append(_year);
		buffer.append(") : ");
		buffer.append(_director);
		return buffer.toString();
  }
}
