package uk.ac.rhul.cs2800;

/** 
 * Observers.
 * 
 * @author Philip
 *
 */
@FunctionalInterface
public interface Observer {
  
  /**
   * Notifies the observer.
   */
  public void notifyObservers();

}
