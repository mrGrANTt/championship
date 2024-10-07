package vxteam.plugin.championship.tools;

import vxteam.plugin.championship.Championship;

public abstract class VortexPlugin {

    //При инициалезации принемает плагин и название файла конфигурации режима
    public VortexPlugin(Championship plg, String configName){
        plg_ = plg;

        config_ = new CustomConfig();
        config_.loadYamlFile(configName, plg);

        activate_ = false;
    }

    //отвечает за включённость мини-игры.
    // ВАЖНО!!! добавляйте эту проверку в любые события плагина
    public boolean activate_;

    private Championship plg_;
    private CustomConfig config_;

    public CustomConfig getConfig() {
        return config_;
    }
    public Championship getPlugin() {
        return plg_;
    }

    public void setActivate(boolean activate) {
        activate_ = activate;
    }

    //функция которая запускается при старте мини-игры
    public abstract void Start();
}
