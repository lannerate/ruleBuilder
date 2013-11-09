package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.shell.as;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.ITreeNode;
import java.io.IOException;
import org.eclipse.swt.widgets.Shell;

public class g extends b
{
  public g(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && ((paramITreeNode instanceof IPage)))
    {
      e();
      new as(new Shell()).b(this.a.getConfigManager().p() + ((IPage)paramITreeNode).getDisplayName());
    }
    else
    {
      e();
      new as(new Shell()).b(this.a.getConfigManager().p());
    }
  }

  public String a()
  {
    return "jspBrowser";
  }

  private void e()
  {
    try
    {
      Runtime.getRuntime().exec("net start \"Apache Tomcat rules\"");
    }
    catch (IOException localIOException)
    {
      return;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.g
 * JD-Core Version:    0.6.0
 */