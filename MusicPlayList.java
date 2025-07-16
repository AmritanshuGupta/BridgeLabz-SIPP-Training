// Node class
class Song
{
	private String name;
	private String singer;
	private String movie;
	Song next,prev;
	public Song(String name, String singer, String movie)
	{
		this.name=name;
		this.singer=singer;
		this.movie=movie;
		this.next=null;
		this.prev=null;
	}
	// Getter methods
	String getName()
	{
		return this.name;
	}
	String getSinger()
	{
		return this.singer;
	}
	String getMovie()
	{
		return this.movie;
	}
}

// Abstract class
abstract class MediaPlayer
{
	abstract void playNext();
}
// Child class : Music Player
class MusicPlayer extends MediaPlayer
{
	Song head,tail;
	static Song currentlyPlaying=null;
	void addAtBeginning(String name, String singer, String movie)
	{
		Song song = new Song(name,singer,movie);
		if(head==null)
		{
			head=tail=song;
			tail.next=head;
			return;
		}
		head.prev=song;
		song.next=head;
		head=song;
	}
	void addAtEnd(String name, String singer, String movie)
	{
		Song song = new Song(name,singer,movie);
		if(head==null)
		{
			head=tail=song;
			tail.next=head;
			return;
		}
		tail.next=song;
		song.prev=tail;
		tail=song;
	}
	void removeAtBeginning()
	{
		if(head==null)
		{
			System.out.println("List Empty");
			return;
		}
		if(head==tail)
		{
			head=tail=null;
			return;
		}
		head=head.next;
		head.prev=null;
	}
	void removeAtEnd()
	{
		if(head==null)
		{
			System.out.println("List Empty");
			return;
		}
		if(head==tail)
		{
			head=tail=null;
			return;
		}
		tail=tail.prev;
		tail.next=null;
	}
	boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	void playNext()
	{
		if(isEmpty())
		{
			System.out.println("Playlist is empty");
		}
		else
		{
			if(currentlyPlaying==null)
			{
				currentlyPlaying=head;
				System.out.println("Currently Playing Song : "+currentlyPlaying.getName());
				System.out.println();
				return;
			}
			else
			{
				Song current=head;
				while(current!=null)
				{
					if(current==currentlyPlaying)
					{
						currentlyPlaying=current.next;
						System.out.println("Currently Playing Song : "+currentlyPlaying.getName());
						System.out.println();
						return;
					}
					current=current.next;
				}
			}
			System.out.println("PlayList Finish");
		}
	}
	void displayPlaylist()
	{
		if(!isEmpty())
		{
			int count=0;
			Song current=head;
			while(current!=null)
			{
				++count;
				System.out.println(count+".\tSong Name->"+current.getName()+"\n\tSinger->"+current.getSinger()+"\n\tMovie->"+current.getMovie());
				System.out.println();
				current=current.next;
			}
		}
		else
		{
			System.out.println("PlayList Empty");
		}
	}
	void displayPlaylistReverse()
	{
		if(!isEmpty())
		{
			int count=0;
			Song current=tail;
			while(current!=null)
			{
				++count;
				System.out.println(count+".\tSong Name->"+current.getName()+"\n\tSinger->"+current.getSinger()+"\n\tMovie->"+current.getMovie());
				System.out.println();
				current=current.prev;
			}
		}
		else
		{
			System.out.println("PlayList Empty");
		}
	}

}

// Main class
public class MusicPlayList
{
	public static void main(String... args)
	{
		MusicPlayer music = new MusicPlayer();
		// Add to the playlist
		music.addAtBeginning("Let It Go", "Idina Menzel", "Frozen");
		music.addAtEnd("Shallow", "Lady Gaga, Bradley Cooper", "A Star Is Born");
		music.addAtBeginning("A Thousand Years", "Christina Perri", "The Twilight Saga: Breaking Dawn - Part 1");
		music.addAtEnd("Take My Breath Away", "Berlin", "Top Gun");
		music.addAtBeginning("Stayin' Alive", "Bee Gees", "Saturday Night Fever");
		music.addAtEnd("Bohemian Rhapsody", "Queen", "Bohemian Rhapsody");
		music.addAtBeginning("Hooked on a Feeling", "Blue Swede", "Guardians of the Galaxy");
		music.addAtEnd("Everything I Do (I Do It for You)", "Bryan Adams", "Robin Hood: Prince of Thieves");
		
		// Display playlist
		music.displayPlaylist();
		
		// Display Current Playing song
		music.playNext();
		music.playNext();
		music.playNext();
		music.playNext();
		music.playNext();
		music.playNext();
	
		// Remove from the playlist
		music.removeAtEnd();
		music.removeAtBeginning();
		music.removeAtEnd();
		music.removeAtBeginning();

		// Display Altered playlist
		music.displayPlaylist();
		music.displayPlaylistReverse();
	}
}