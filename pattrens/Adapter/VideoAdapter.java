package katrenich.pattrens.Adapter;

/**
  * Паттерн проектування Адаптер реалізовано за допомогою парадигми ООП - наслідування.
  *  Клас VideoAdapter наслідує Адаптивний клас VGAMonitor та імплементує цільовий інтерфейс HDMIOutput
  * */

public class VideoAdapter extends VGAMonitor implements HDMIOutput{
	public void showVideoHDMI() {
		showVideoVGA();
	}
}
