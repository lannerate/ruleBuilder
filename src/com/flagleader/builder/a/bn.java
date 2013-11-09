package com.flagleader.builder.a;

import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class bn extends a
  implements IElementViewer
{
  private RulePackage e;
  private Browser f;
  private StyledText g;

  public bn(RulePackage paramRulePackage, Composite paramComposite, bu parambu)
  {
    super(paramRulePackage, paramComposite, parambu);
    this.e = paramRulePackage;
    try
    {
      e();
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void e()
  {
    try
    {
      this.f = new Browser(this.b, 0);
      GridData localGridData = new GridData(1808);
      localGridData.horizontalAlignment = 4;
      localGridData.grabExcessHorizontalSpace = true;
      localGridData.verticalAlignment = 4;
      localGridData.grabExcessVerticalSpace = true;
      this.f.setLayoutData(localGridData);
      localObject = Display.getDefault().getSystemColor(29);
      this.f.setBackground((Color)localObject);
      this.f.setForeground(Display.getDefault().getSystemColor(9));
    }
    catch (Exception localException)
    {
      Object localObject = new com.flagleader.builder.widget.a.k(a(), this.b, 8456770);
      this.g = ((com.flagleader.builder.widget.a.k)localObject).m();
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    String str = SystemUtils.JAVA_IO_TMPDIR;
    File localFile = new File(str + File.separator + this.e.getUuid(), this.e.getEditUuid() + "db.html");
    localFile.getParentFile().mkdirs();
    try
    {
      if ((!localFile.exists()) || (this.e.getMaxModifyTime() > localFile.lastModified()) || (this.e.getEnvionment().getMaxModifyTime() > localFile.lastModified()))
      {
        FileWriter localFileWriter = new FileWriter(localFile);
        localFileWriter.write(new com.flagleader.repository.e.k().a(this.e.getEnvionment()));
        localFileWriter.flush();
        localFileWriter.close();
      }
      if (this.f != null)
      {
        this.f.setUrl(localFile.getPath());
        this.f.update();
      }
      else
      {
        this.g.setText(FileUtil.readFromFile(localFile));
        this.g.update();
      }
    }
    catch (IOException localIOException)
    {
      if (this.f != null)
      {
        this.f.setText(new com.flagleader.repository.e.k().a(this.e.getEnvionment()));
      }
      else
      {
        this.g.setText(new com.flagleader.repository.e.k().a(this.e.getEnvionment()));
        this.g.update();
      }
    }
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.e.getMaxModifyTime()) || (this.d < this.e.getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return this.e.getEditUuid() + "dbhtml";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.bn
 * JD-Core Version:    0.6.0
 */