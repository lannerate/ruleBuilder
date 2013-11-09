package com.flagleader.builder.actions;

import java.io.File;
import java.io.FilenameFilter;

class ay
  implements FilenameFilter
{
  ay(aq paramaq)
  {
  }

  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("stdout_");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ay
 * JD-Core Version:    0.6.0
 */