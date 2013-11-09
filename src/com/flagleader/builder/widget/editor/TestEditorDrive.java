package com.flagleader.builder.widget.editor;

import com.flagleader.builder.widget.editor.g.c;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestEditorDrive extends ApplicationWindow
{
  private s a = new c();

  public TestEditorDrive()
  {
    super(null);
    addMenuBar();
    addToolBar(8388608);
  }

  protected MenuManager createMenuManager()
  {
    return this.a.l();
  }

  protected ToolBarManager createToolBarManager(int paramInt)
  {
    return this.a.b(paramInt);
  }

  protected void configureShell(Shell paramShell)
  {
    super.configureShell(paramShell);
    paramShell.setText("JavaScript 编辑器");
    paramShell.setSize(600, 400);
  }

  protected Control createContents(Composite paramComposite)
  {
    this.a.a(paramComposite, 768);
    return paramComposite;
  }

  public static void main(String[] paramArrayOfString)
  {
    TestEditorDrive localTestEditorDrive = new TestEditorDrive();
    localTestEditorDrive.setBlockOnOpen(true);
    localTestEditorDrive.open();
    Display.getCurrent().dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.TestEditorDrive
 * JD-Core Version:    0.6.0
 */