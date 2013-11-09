package com.flagleader.builder.shell;

import com.flagleader.engine.Property;
import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.logging.Level;

class r
  implements Runnable
{
  r(ClassInfoEditor paramClassInfoEditor, InfoClass paramInfoClass)
  {
  }

  public void run()
  {
    try
    {
      Class localClass = ClassInfoEditor.b(this.a, this.b.getClassName());
      if (localClass != null)
      {
        this.b.updateClass(localClass);
        ClassInfoEditor.b(this.a, this.b);
      }
      ClassInfoEditor.a(this.a, "finish compile " + this.b.getClassName(), Level.INFO);
    }
    catch (Exception localException1)
    {
      File localFile = new File(Property.getInstance().getRuleEngineClassDir(), this.b.getClassName().replace('.', File.separatorChar) + ".java");
      try
      {
        ClassInfoEditor.a(this.a, FileUtil.readFromFile(localFile), localException1.getLocalizedMessage());
      }
      catch (Exception localException2)
      {
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.r
 * JD-Core Version:    0.6.0
 */