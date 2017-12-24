package katrenich.pattrens.Adapter;

/**
 * Паттерн проектування Адаптер реалізовано за допомогою композиції.
 * Створюється екземпляр класу VGAMonitor та викликається його метод в імплементованому методі
 * інтерфейсу HDMIOutput(showVideoHDMI).
 */
public class VideoAdapterCom implements HDMIOutput{
	VGAMonitor vga = new VGAMonitor();

	public void showVideoHDMI() {
		vga.showVideoVGA();
	}
}
