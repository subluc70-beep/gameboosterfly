from jnius import autoclass
from kivy.app import App

class LokiBooster(App):
    def calcular_graficos(self, tipo):
        # Matemática dos Presets
        valores = {"minecraft": 0.4, "massinha": 0.6, "normal": 1.0}
        escala = valores.get(tipo, 1.0)
        
        # Chama o Java Nativo
        Manager = autoclass('com.seunome.gamebooster.ShizukuManager')
        if Manager.temPermissao():
            cmd = f"cmd game set --downscale {escala} com.dts.freefireth"
            Manager.executarComando(cmd)
            # Chama o script de CPU/GPU
            Manager.executarComando("sh /sdcard/LokiBooster/optimizer.sh")

    def toggle_fps_monitor(self):
        # Lógica para mostrar o FPS estilo Emulador
        pass
