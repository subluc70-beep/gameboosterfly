package com.seunome.gamebooster;

import dev.rikka.shizuku.Shizuku;
import android.content.pm.PackageManager;

public class ShizukuManager {

    public static boolean temPermissao() {
        if (Shizuku.pingBinder()) {
            return Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    public static void executarComando(String comando) {
        try {
            // Execução via Binder Nativo (Mais rápido que Risu)
            Shizuku.newProcess(new String[]{"sh", "-c", comando}, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
