package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public abstract class FileReader {
  private String fileName;

  public FileReader(String file){
    fileName = file;
  }

  public String getFileName() {
    return fileName;
  }

  public abstract String readFile();
}
