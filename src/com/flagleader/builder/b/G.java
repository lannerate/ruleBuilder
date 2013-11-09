package com.flagleader.builder.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.f.aW;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.tree.RuleFlowTransition;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class G extends r
{
  private RuleFlowTransition a;
  private Text b;
  private BuilderManager c;

  private G(Shell paramShell)
  {
    super(paramShell);
  }

  public G(Shell paramShell, BuilderManager paramBuilderManager, RuleFlowTransition paramRuleFlowTransition)
  {
    this(paramShell);
    this.c = paramBuilderManager;
    this.a = paramRuleFlowTransition;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.RuleFlowPropertiesDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    if (this.a == null)
      return localComposite1;
    localComposite1.setLayout(a(1));
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    d(localComposite2);
    b(localComposite1);
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayout(a(1));
    localComposite3.setLayoutData(a(500, 400));
    c(localComposite3);
    return localComposite1;
  }

  protected void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setBackground(h.d);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    new aW(this.a, localComposite, this.c.getRuleEditor()).update();
  }

  protected void d(Composite paramComposite)
  {
    a(paramComposite).setText(a("name.dialog") + ":  ");
    this.b = a(paramComposite, 2048, 400, 10);
    this.b.setText(this.a.getDisplayName());
  }

  protected void okPressed()
  {
    int i = 0;
    if (!this.a.getDisplayName().equals(this.b.getText()))
    {
      this.a.setDisplayName(this.b.getText());
      i = 1;
    }
    if (i != 0)
      this.a.setModified(true);
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.G
 * JD-Core Version:    0.6.0
 */