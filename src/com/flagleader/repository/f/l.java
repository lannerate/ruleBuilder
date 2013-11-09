package com.flagleader.repository.f;

import java.io.File;
import java.io.FileFilter;

class l
  implements FileFilter
{
  l(k paramk)
  {
  }

  public boolean accept(File paramFile)
  {
    if (paramFile.getName().endsWith(".rpk"))
      return true;
    return paramFile.isDirectory();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.l
 * JD-Core Version:    0.6.0
 */