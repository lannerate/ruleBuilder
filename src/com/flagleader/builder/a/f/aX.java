package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.IApplication;
import com.flagleader.builder.a.a;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RuleSetFlow;
import java.io.File;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class aX extends a
  implements IElementViewer
{
  private RuleSetFlow f;
  private Browser g;
  boolean e = false;
  private boolean h = false;
  private String i = "";

  public aX(RuleSetFlow paramRuleSetFlow, Composite paramComposite, bu parambu)
  {
    super(paramRuleSetFlow, paramComposite, parambu);
    this.f = paramRuleSetFlow;
    e();
  }

  private void e()
  {
    this.g = new Browser(this.b, 0);
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    this.g.setLayoutData(localGridData);
    Color localColor = Display.getDefault().getSystemColor(29);
    this.g.setBackground(localColor);
    this.g.setForeground(Display.getDefault().getSystemColor(9));
    this.g.addFocusListener(new ba(this));
    this.g.addTitleListener(new aY(this));
    this.g.addStatusTextListener(new aZ(this));
    String str = a().getMainApp().getFlowPath();
    try
    {
      this.g.setUrl(new File(str, "index.html").getPath());
      this.g.update();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    if (this.h)
      this.g.execute("setXml('" + this.f.getDisplayName() + "','" + this.f.getFlowXml().replace('\n', ' ').replace('\r', ' ') + "');");
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.f.getMaxModifyTime()) || (this.d < this.f.getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return this.f.getEditUuid() + "flow";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aX
 * JD-Core Version:    0.6.0
 */