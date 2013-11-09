package com.flagleader.builder.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.f.bm;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class p extends r
{
  private IMultiLineEditen a;
  private Text b;
  private BuilderManager c;

  private p(Shell paramShell)
  {
    super(paramShell);
  }

  public p(Shell paramShell, BuilderManager paramBuilderManager, IMultiLineEditen paramIMultiLineEditen)
  {
    this(paramShell);
    this.c = paramBuilderManager;
    this.a = paramIMultiLineEditen;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    super.setMessage(a("title.DecisionMultiRuleValueDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    if (this.a == null)
      return localComposite1;
    localComposite1.setLayout(a(1));
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(600, 300));
    c(localComposite2);
    return localComposite1;
  }

  protected void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setBackground(h.d);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    new bm(this.a, localComposite, this.c.getRuleEditor()).update();
  }

  protected void d(Composite paramComposite)
  {
  }

  protected void okPressed()
  {
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.p
 * JD-Core Version:    0.6.0
 */