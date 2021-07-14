package web_movie_proj.dto;

public class MailDTO {
	private String subject;
	private String text;
	private String from;
	private String to;

	public MailDTO(String subject, String text, String from, String to) {
		super();
		this.subject = subject;
		this.text = text;
		this.from = from;
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return String.format("MailDTO [subject=%s, text=%s, from=%s, to=%s]", subject, text, from, to);
	}

	
}
