package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aL;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.a.v;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.util.HashMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class bn extends aL
  implements com.flagleader.builder.a.bq, IElementViewer
{
  private BuilderManager g;
  private HashMap q = new HashMap();
  private String r;

  public bn(RulePackage paramRulePackage, Composite paramComposite, bu parambu)
  {
    super(paramRulePackage, paramComposite, parambu);
    this.g = parambu.i();
  }

  protected aS e(Composite paramComposite)
  {
    return new bn((RulePackage)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "export");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new bt(this));
    a(new bs(this));
    super.h();
  }

  private RulePackage e()
  {
    return (RulePackage)this.c;
  }

  private void f()
  {
    FileDialog localFileDialog = new FileDialog(a().getShell(), 8192);
    localFileDialog.setFileName(e().getClassName() + ".java");
    localFileDialog.setFilterExtensions(new String[] { "*.java" });
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        FileUtil.writeFile(str, this.r.getBytes());
        a().showSuccess(c.a("HasBeenExport", new String[] { str }));
      }
      catch (Exception localException)
      {
        a().getRulesManager().j().b(localException.getMessage());
      }
  }

  protected af b(Composite paramComposite)
  {
    this.e = new v(a(), paramComposite, 68354);
    StyledText localStyledText = this.e.m();
    localStyledText.setEditable(false);
    localStyledText.setBackground(Display.getDefault().getSystemColor(29));
    localStyledText.setForeground(Display.getDefault().getSystemColor(9));
    localStyledText.addMouseMoveListener(new bo(this, localStyledText));
    localStyledText.addMouseListener(new bp(this, localStyledText));
    return this.e;
  }

  private void a(boolean paramBoolean)
  {
    bq localbq = new bq(this, paramBoolean);
    a(localbq, true);
    localbq.start();
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    a(false);
    super.update();
  }

  private void c(String paramString)
  {
    this.e.m().getDisplay().asyncExec(new br(this, paramString));
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < e().getMaxModifyTime()) || (this.d < e().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "java";
  }

  protected void a(String paramString)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bn
 * JD-Core Version:    0.6.0
 */