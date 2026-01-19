#!/system/bin/sh

# 1. Prioridade Máxima de CPU
for cpu in /sys/devices/system/cpu/cpu*/cpufreq/scaling_governor; do
    echo "performance" > $cpu
done

# 2. Prioridade de Renderização GPU
setprop debug.hwui.overdraw false
setprop persist.sys.ui.hw true

# 3. FPS Unlocker (Tenta forçar o buffer)
setprop debug.gr.num_framebuffer_surface 3

echo "Loki Booster: CPU e GPU em modo Máximo!"
